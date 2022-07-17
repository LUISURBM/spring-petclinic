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
                    <t:panelTab label="Historia Prenatal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuHistoriaPrenatal.irDatosPrenatal}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaPrenatal.irCuestionarioCovidPrenatal}" immediate="true"
                                            rendered="#{menuHistoriaPrenatal.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta" action="#{menuHistoriaPrenatal.irMotivoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderMotivo}"/>
                            <h:commandLink value="Antecedentes prenatal"
                                           action="#{menuHistoriaPrenatal.irAntecedentesEspecificosPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderAntecedentesPrenatal}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaPrenatal.irAntecedentesGinecologicosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderAntecedentesGinecologicos}"/>
                                           
                            <h:commandLink value="Antecedentes Obstetricos"
                                           action="#{menuHistoriaPrenatal.irAntecedentesObstetricosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderAntecedentesObstetricos}"/>
                            <h:commandLink value="Gestación Prenatal"
                                           action="#{menuHistoriaPrenatal.irGestacionPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderGestacionPrenatal}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaPrenatal.irEncuestaViolenciaPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaPrenatal.irEscalaValoracionCaidasPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderEscalaCaidas}"/>                 
                            <h:commandLink value="Exámen Fisico Prenatal"
                                           action="#{menuHistoriaPrenatal.irExamenFisicoPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaPrenatal.irImpDiagnosticaPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaPrenatal.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Tamizaje Prenatal" action="#{menuHistoriaPrenatal.irTamizajePrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderTamizajePrenatal}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaPrenatal.irServiciosAdmisionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderServiciosAdmision}"/>
                                           
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaPrenatal.irAnatPatologicaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaPrenatal.irControlSinCostoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPrenatal.irFormulaMedicaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta && !menuHistoriaPrenatal.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPrenatal.irVademecumMedicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta && menuHistoriaPrenatal.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaPrenatal.irRemHospitalizacionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaPrenatal.irIncapacidadPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaPrenatal.irInterConsultaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaPrenatal.irOrdenCirugiaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaPrenatal.irRecomedacionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaPrenatal.irReferenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaPrenatal.irReservaSangrePrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaPrenatal.irCertMedicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaPrenatal.irCertAsistenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaPrenatal.irExamElectrofisiologicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaPrenatal.irExamImagenPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaPrenatal.irExamLaboratorioPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderConducta}"/>
                          
                          
                            <h:commandLink value="Pre - visualizar consulta" action="#{menuHistoriaPrenatal.irCerrarConsultaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaPrenatal.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                               <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaPrenatal.irResumenHistoriaPrenatal}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaPrenatal.irPausarConsultaPrenatal}"
                                   rendered="#{menuHistoriaPrenatal.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>