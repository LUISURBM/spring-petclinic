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
                    <t:panelTab label="Procesos de Otras Especialidades" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaDermatologicaBean.irDatosDermatologia}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaDermatologicaBean.irCuestionarioCovidDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaDermatologicaBean.irMotivoDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaDermatologicaBean.irAntecedentesDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderAntecedentesGenerales && !menuHistoriaDermatologicaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaDermatologicaBean.irAntecedentesDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderAntecedentesGenerales && menuHistoriaDermatologicaBean.primeraConsulta}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaDermatologicaBean.irEncuestaViolenciaDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaDermatologicaBean.irEscalaValoracionCaidasOtrasEspecialidades}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderEscalaCaidas}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaDermatologicaBean.irExamenFisicoDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaDermatologicaBean.irImpDiagnosticaDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaDermatologicaBean.irServiciosAdmisionOtrasEspecialidades}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderServiciosAdmision}"/>
                              <h:outputText value="Ordenes Médicas (Cirugía/Procedimientos)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaDermatologicaBean.renderConducta && menuHistoriaDermatologicaBean.renderOrdenesMedicas}"/>
                             <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaDermatologicaBean.irOrdenLiquidosDermatologia}"
                                           rendered="#{menuHistoriaDermatologicaBean.renderConducta && menuHistoriaDermatologicaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaDermatologicaBean.irOrdenMedicamentosDermatologia}" immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderConducta && menuHistoriaDermatologicaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaDermatologicaBean.irRegistrarOtrasOrdenesDermatologia}" immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderConducta && menuHistoriaDermatologicaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaDermatologicaBean.irAnatPatologicaDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaDermatologicaBean.irControlSinCostoDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaDermatologicaBean.irFormulaMedicaDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderConducta && !menuHistoriaDermatologicaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaDermatologicaBean.irVademecumMedicoDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderConducta && menuHistoriaDermatologicaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaDermatologicaBean.irRemHospitalizacionDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaDermatologicaBean.irIncapacidadDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaDermatologicaBean.irInterConsultaDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaDermatologicaBean.irOrdenCirugiaDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaDermatologicaBean.irRecomedacionDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaDermatologicaBean.irReferenciaDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaDermatologicaBean.irAutorizacionServicioDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaDermatologicaBean.irReservaSangreDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaDermatologicaBean.irCertMedicoDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaDermatologicaBean.irCertAsistenciaDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaDermatologicaBean.irExamElectrofisiologicoDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaDermatologicaBean.irExamImagenDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaDermatologicaBean.irExamLaboratorioDermatologia}"
                                           immediate="true" rendered="#{menuHistoriaDermatologicaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaDermatologicaBean.irCerrarConsultaDermatologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaDermatologicaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaDermatologicaBean.irResumenHistoriaDermatologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaDermatologicaBean.irPausarConsultaOtrasEspecialidades}"
                                           rendered="#{menuHistoriaDermatologicaBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>