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
                                           action="#{menuHistoriaAnticoncepcionRetiro.irDatosAnticoncepcion}"
                                           immediate="true"/>
                                           
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irCuestionarioCovidAnticoncepcion}" immediate="true"
                                            rendered="#{menuHistoriaAnticoncepcionRetiro.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderAntecedentesGenerales && menuHistoriaAnticoncepcionRetiro.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionRetiro.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irEscalaValoracionCaidasAnticoncepcionInsercion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionRetiro.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderImpresionDiagnostica}"/>
                                           
                             <h:commandLink value="Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderRetiroMetodo}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irServiciosAdmisionAnticoncepcionRetiro}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionRetiro.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                           
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                        
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta && !menuHistoriaAnticoncepcionRetiro.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta && menuHistoriaAnticoncepcionRetiro.renderVademecum}"/>
                                           
                        
                        
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                             <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionRetiro.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis" style="font-color:red;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionRetiro.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaAnticoncepcionRetiro.irPausarConsultaAnticoncepcionRetiro}"
                                   rendered="#{menuHistoriaAnticoncepcionRetiro.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>