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
                    <t:panelTab label="Historia de Pediatria" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaPediatria.irDatosPediatria}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaPediatria.irCuestionarioCovidPediatria}" immediate="true"
                                            rendered="#{menuHistoriaPediatria.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaPediatria.irMotivoPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaPediatria.irAntecedentesGeneralesPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderAntecedentesGenerales && menuHistoriaPediatria.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaPediatria.irAntecedentesPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderAntecedentesGenerales && !menuHistoriaPediatria.primeraConsulta}"/>
                           <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaPediatria.irAntecedentesGinecologicosPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaPediatria.irEncuestaViolenciaPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaPediatria.irExamenFisicoPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderExamen}"/>
                            <h:commandLink value="Exámen Pediatria"
                                           action="#{menuHistoriaPediatria.irExamenPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderExamenPediatria}"/>                                           
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaPediatria.irEscalaValoracionCaidasPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderEscalaCaidas}"/>              
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaPediatria.irImpDiagnosticaPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderImpresionDiagnostica}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaPediatria.irServiciosAdmisionPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderServiciosAdmision}"/>
										   
                                    <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaPediatria.irAnatPatologicaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaPediatria.irControlSinCostoPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPediatria.irFormulaMedicaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta && !menuHistoriaPediatria.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPediatria.irVademecumMedicoPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta && menuHistoriaPediatria.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaPediatria.irRemHospitalizacionPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaPediatria.irIncapacidadPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaPediatria.irInterConsultaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaPediatria.irOrdenCirugiaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaPediatria.irRecomedacionPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaPediatria.irReferenciaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaPediatria.irAutorizacionServicioPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaPediatria.irReservaSangrePediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaPediatria.irCertMedicoPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaPediatria.irCertAsistenciaPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaPediatria.irExamElectrofisiologicoPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaPediatria.irExamImagenPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaPediatria.irExamLaboratorioPediatria}"
                                           immediate="true" rendered="#{menuHistoriaPediatria.renderConducta}"/>
                             <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaPediatria.irCerrarConsultaPediatria}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPediatria.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                                        
                               <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaPediatria.irResumenHistoriaPediatria}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaPediatria.irPausarConsultaPediatria}"
                                   rendered="#{menuHistoriaPediatria.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>