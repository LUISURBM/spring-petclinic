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
                    <t:panelTab label="Procesos de Salud Sexual" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaSaludSexualBean.irDatosSaludSexual}" immediate="true"/>
                                           
                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaSaludSexualBean.irCuestionarioCovidSaludSexual}" immediate="true"
                                            rendered="#{menuHistoriaSaludSexualBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaSaludSexualBean.irMotivoSaludSexual}" immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderMotivo}"/>
                            <h:commandLink value="Paraclinicos"
                                           action="#{menuHistoriaSaludSexualBean.irParaclinicosSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderParaclinicos}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaSaludSexualBean.irAntecedentesGeneralesSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderAntecedentesGenerales && menuHistoriaSaludSexualBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaSaludSexualBean.irAntecedentesSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderAntecedentesGenerales && !menuHistoriaSaludSexualBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaSaludSexualBean.irAntecedentesGinecologicosSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaSaludSexualBean.irEncuestaViolenciaSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaSaludSexualBean.irEscalaValoracionCaidasSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaSaludSexualBean.irExamenFisicoSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaSaludSexualBean.irImpDiagnosticaSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderImpresionDiagnostica}"/>
                            <h:outputText value="Ordenes Médicas (Cirugía/Procedimientos)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaSaludSexualBean.renderConducta && menuHistoriaSaludSexualBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaSaludSexualBean.irOrdenLiquidosSaludSexual}"
                                           rendered="#{menuHistoriaSaludSexualBean.renderConducta && menuHistoriaSaludSexualBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaSaludSexualBean.irOrdenMedicamentosSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderConducta && menuHistoriaSaludSexualBean.renderOrdenesMedicas}"/>
                        <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaSaludSexualBean.irRegistrarOtrasOrdenesSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderConducta && menuHistoriaSaludSexualBean.renderOrdenesMedicas}"/>
                                           
                                           
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaSaludSexualBean.irServiciosAdmisionSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaSaludSexualBean.irAnatPatologicaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Violencia Sivigila"
                                           action="#{menuHistoriaSaludSexualBean.irViolenciaSivigilaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaSaludSexualBean.irControlSinCostoSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaSaludSexualBean.irVademecumMedicoSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderConducta && menuHistoriaSaludSexualBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaSaludSexualBean.irRemHospitalizacionSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaSaludSexualBean.irIncapacidadSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaSaludSexualBean.irInterConsultaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaSaludSexualBean.irOrdenCirugiaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaSaludSexualBean.irRecomedacionSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaSaludSexualBean.irReferenciaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaSaludSexualBean.irAutorizacionServicioSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaSaludSexualBean.irReservaSangreSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaSaludSexualBean.irCertMedicoSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaSaludSexualBean.irCertAsistenciaSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaSaludSexualBean.irExamElectrofisiologicoSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaSaludSexualBean.irExamImagenSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaSaludSexualBean.irExamLaboratorioSaludSexual}"
                                           immediate="true" rendered="#{menuHistoriaSaludSexualBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaSaludSexualBean.irCerrarConsultaSaludSexual}"
                                           immediate="true"
                                           rendered="#{menuHistoriaSaludSexualBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaSaludSexualBean.irResumenHistoriaSaludSexual}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaSaludSexualBean.irPausarConsultaSaludSexual}"
                                   rendered="#{menuHistoriaSaludSexualBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>