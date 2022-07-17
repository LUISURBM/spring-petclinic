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
                    <t:panelTab label="Historia Control Prenatal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaControlPrenatal.irDatosControlPrenatal}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaControlPrenatal.irCuestionarioCovidControlPrenatal}" immediate="true"
                                            rendered="#{menuHistoriaControlPrenatal.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaControlPrenatal.irMotivoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderMotivo}"/>
                            <h:commandLink value="Gestación Prenatal"
                                           action="#{menuHistoriaControlPrenatal.irGestacionControlPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPrenatal.renderGestacionControlPrenatal}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaControlPrenatal.irEncuestaViolenciaControlPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPrenatal.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaControlPrenatal.irEscalaValoracionCaidasControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderEscalaCaidas}"/>                 
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaControlPrenatal.irExamenFisicoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaControlPrenatal.irImpDiagnosticaControlPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPrenatal.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Tamizaje Prenatal"
                                           action="#{menuHistoriaControlPrenatal.irTamizajeControlPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPrenatal.renderTamizajePrenatal}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaControlPrenatal.irServiciosAdmisionControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderServiciosAdmision}"/>			   
                  <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaControlPrenatal.irAnatPatologicaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaControlPrenatal.irControlSinCostoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlPrenatal.irFormulaMedicaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta && !menuHistoriaControlPrenatal.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlPrenatal.irVademecumMedicoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta && menuHistoriaControlPrenatal.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaControlPrenatal.irRemHospitalizacionControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaControlPrenatal.irIncapacidadControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaControlPrenatal.irInterConsultaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaControlPrenatal.irOrdenCirugiaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaControlPrenatal.irRecomedacionControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaControlPrenatal.irReferenciaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaControlPrenatal.irReservaSangreControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaControlPrenatal.irCertMedicoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaControlPrenatal.irCertAsistenciaControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaControlPrenatal.irExamElectrofisiologicoControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaControlPrenatal.irExamImagenControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaControlPrenatal.irExamLaboratorioControlPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaControlPrenatal.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuHistoriaControlPrenatal.irCerrarConsultaControlPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaControlPrenatal.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                              <h:commandLink value="Historia Total "
                                           action="#{menuHistoriaControlPrenatal.irResumenHistoriaControlPrenatal}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaControlPrenatal.irPausarConsultaControlPrenatal}"
                                   rendered="#{menuHistoriaControlPrenatal.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>