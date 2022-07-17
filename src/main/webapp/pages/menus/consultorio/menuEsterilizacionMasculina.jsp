0p1|<%@ page contentType="text/html;charset=iso-8859-1"%>
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
                    <t:panelTab label="Procesos de Esterilización Masculina" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaEsterilizacionMasculina.irDatosEsterilizacionMasculina}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaEsterilizacionMasculina.irCuestionarioEsterilizacionMasculina}" immediate="true"
                                            rendered="#{menuHistoriaEsterilizacionMasculina.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaEsterilizacionMasculina.irMotivoEsterilizacionMasculina}" immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderMotivo}"/>
                            <h:commandLink value="Cuestionario Esterilización"
                                           action="#{menuHistoriaEsterilizacionMasculina.irEsterilizacionMasculina}" immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderEsterilizacion}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEsterilizacionMasculina.irAntecedentesGeneralesEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderAntecedentesGenerales && menuHistoriaEsterilizacionMasculina.primeraConsulta}"/>
                            
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEsterilizacionMasculina.irAntecedentesEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderAntecedentesGenerales && !menuHistoriaEsterilizacionMasculina.primeraConsulta}"/>
                                           
                            <h:commandLink value="Otros Antecedentes"
                                           action="#{menuHistoriaEsterilizacionMasculina.irOtrosAntecedentesEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderOtrosAntecedentes}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaEsterilizacionMasculina.irEncuestaViolenciaEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaEsterilizacionMasculina.irEscalaValoracionCaidasEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderEscalaCaidas}"/>                     
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaEsterilizacionMasculina.irExamenFisicoEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaEsterilizacionMasculina.irImpDiagnosticaEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderImpresionDiagnostica}"/>
                             <h:commandLink value="Métodos Anticonceptivos"
                                           action="#{menuHistoriaEsterilizacionMasculina.irMetodoAnticonceptivoEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderMetodosPlanificacion}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaEsterilizacionMasculina.irServiciosAdmisionEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderServiciosAdmision}"/>	
                                           
                             <h:outputText value="Ordenes Médicas (Cirugía)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                                        
                             <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaEsterilizacionMasculina.irOtrasOrdenesEsterilizacionMasculina}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>               
                                           
                 <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaEsterilizacionMasculina.irAnatPatologicaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaEsterilizacionMasculina.irControlSinCostoEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaEsterilizacionMasculina.irFormulaMedicaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta && !menuHistoriaEsterilizacionMasculina.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaEsterilizacionMasculina.irVademecumMedicoEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta && menuHistoriaEsterilizacionMasculina.renderVademecum}"/>
                                           
                        
                           
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaEsterilizacionMasculina.irRemHospitalizacionEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaEsterilizacionMasculina.irIncapacidadEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaEsterilizacionMasculina.irInterConsultaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaEsterilizacionMasculina.irOrdenCirugiaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaEsterilizacionMasculina.irRecomedacionEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaEsterilizacionMasculina.irReferenciaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaEsterilizacionMasculina.irAutorizacionServicioEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaEsterilizacionMasculina.irReservaSangreEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaEsterilizacionMasculina.irCertMedicoEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaEsterilizacionMasculina.irCertAsistenciaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaEsterilizacionMasculina.irExamElectrofisiologicoEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaEsterilizacionMasculina.irExamImagenEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaEsterilizacionMasculina.irExamLaboratorioEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderConducta}"/>
                              <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaEsterilizacionMasculina.irCerrarConsultaEsterilizacionMasculina}"
                                           immediate="true" rendered="#{menuHistoriaEsterilizacionMasculina.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                           
                                  <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaEsterilizacionMasculina.irResumenHistoriaEsterilizacionMasculina}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaEsterilizacionMasculina.irPausarConsultaEsterilizacionMasculina}"
                                   rendered="#{menuHistoriaEsterilizacionMasculina.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>