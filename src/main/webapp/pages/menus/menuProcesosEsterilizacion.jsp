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
                    <t:panelTab label="Procesos de Esterilización" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuProcesosEsterilizacionBean.irDatosEsterilizacion}"
                                           immediate="true"/>
                                           
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuProcesosEsterilizacionBean.irCuestionarioCovidEsterilizacion}"
                                           rendered="#{menuProcesosEsterilizacionBean.renderCovid}"
                                           immediate="true"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuProcesosEsterilizacionBean.irMotivoEsterilizacion}"
                                           immediate="true" rendered="#{menuProcesosEsterilizacionBean.renderMotivo}"/>
                            <h:commandLink value="Cuestionario de Tamizaje"
                                           action="#{menuProcesosEsterilizacionBean.irCuestionarioEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderCuestionario}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuProcesosEsterilizacionBean.irAntecedentesGeneralesEsterilizacionFemenina}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderAntecedentesGenerales && menuProcesosEsterilizacionBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuProcesosEsterilizacionBean.irAntecedentesEsterilizacionFemenina}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderAntecedentesGenerales && !menuProcesosEsterilizacionBean.primeraConsulta}"/>
                            <h:commandLink value="Formula Obstétrica"
                                           action="#{menuProcesosEsterilizacionBean.irAntGinecologicos}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderAntGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuProcesosEsterilizacionBean.irEncuestaViolenciaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuProcesosEsterilizacionBean.irEscalaValoracionCaidasEsterilizacionFemenina}"
                                           immediate="true" rendered="#{menuProcesosEsterilizacionBean.renderEscalaCaidas}"/>                     
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuProcesosEsterilizacionBean.irExamenFisicoEsterilizacion}"
                                           immediate="true" rendered="#{menuProcesosEsterilizacionBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuProcesosEsterilizacionBean.irImpDiagnosticaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderImpresionDiagnostica}"/>
                                           
                           <h:outputText value="Ordenes Médicas (Cirugía)" styleClass="label_itemmenu"
                                          rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuProcesosEsterilizacionBean.irOrdenLiquidosEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuProcesosEsterilizacionBean.irOrdenMedicamentosEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/> 
                                           
                             <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuProcesosEsterilizacionBean.irOtrasOrdenesEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/> 
                   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuProcesosEsterilizacionBean.irAnatPatologicaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuProcesosEsterilizacionBean.irControlSinCostoEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcesosEsterilizacionBean.irFormulaMedicaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuProcesosEsterilizacionBean.irRemHospitalizacionEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuProcesosEsterilizacionBean.irIncapacidadEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuProcesosEsterilizacionBean.irInterConsultaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuProcesosEsterilizacionBean.irOrdenCirugiaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuProcesosEsterilizacionBean.irRecomedacionEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuProcesosEsterilizacionBean.irReferenciaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuProcesosEsterilizacionBean.irReservaSangreEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuProcesosEsterilizacionBean.irCertMedicoEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuProcesosEsterilizacionBean.irCertAsistenciaEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuProcesosEsterilizacionBean.irExamElectrofisiologicoEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuProcesosEsterilizacionBean.irExamImagenEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuProcesosEsterilizacionBean.irExamLaboratorioEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuProcesosEsterilizacionBean.irCerrarEsterilizacion}"
                                           immediate="true"
                                           rendered="#{menuProcesosEsterilizacionBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                           <h:commandLink value="Historia Total"
                                           action="#{menuProcesosEsterilizacionBean.irResumenHistoriaEsterilizacionFemenina}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuProcesosEsterilizacionBean.irPausarConsultaEsterilizacionFemenina}"
                                   rendered="#{menuProcesosEsterilizacionBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>