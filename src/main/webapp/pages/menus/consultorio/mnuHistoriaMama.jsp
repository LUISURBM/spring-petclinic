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
                    <t:panelTab label="Historia Mama" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaMama.irDatosMama}"
                                           immediate="true"/>
                             <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaMama.irCuestionarioCovidoMama}" immediate="true"
                                            rendered="#{menuHistoriaMama.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaMama.irMotivoMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaMama.irAntecedentesGeneralesMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderAntecedentesGenerales && menuHistoriaMama.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaMama.irAntecedentesMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderAntecedentesGenerales && !menuHistoriaMama.primeraConsulta}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaMama.irEncuestaViolenciaMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderEncuestaViolencia}"/>
                            <h:commandLink value="Riesgo Mama"
                                           action="#{menuHistoriaMama.irRiesgoMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderRiesgo}"/>
                             <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaMama.irEscalaValoracionCaidasMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderEscalaCaidas}"/>              
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaMama.irExamenFisicoMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaMama.irImpDiagnosticaMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderImpresionDiagnostica}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaMama.irServiciosAdmisionMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderServiciosAdmision}"/>			   
                        
                         <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaMama.irAnatPatologicaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaMama.irControlSinCostoMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaMama.irFormulaMedicaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta && !menuHistoriaMama.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaMama.irVademecumMedicoMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta && menuHistoriaMama.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaMama.irRemHospitalizacionMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaMama.irIncapacidadMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaMama.irInterConsultaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaMama.irOrdenCirugiaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaMama.irRecomedacionMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaMama.irReferenciaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaMama.irReservaSangreMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaMama.irCertMedicoMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaMama.irCertAsistenciaMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaMama.irExamElectrofisiologicoMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaMama.irExamImagenMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaMama.irExamLaboratorioMama}"
                                           immediate="true" rendered="#{menuHistoriaMama.renderConducta}"/>
                          
                          
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuHistoriaMama.irCerrarConsultaMama}"
                                           immediate="true"
                                           rendered="#{menuHistoriaMama.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">                                       
                             <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaMama.irResumenHistoriaMama}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaMama.irPausarConsultaExamenMama}"
                                   rendered="#{menuHistoriaMama.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>