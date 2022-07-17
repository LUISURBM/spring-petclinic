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
                    <t:panelTab label="Historia Nuevo Prenatal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaNuevoPrenatalBean.irDatosPrenatal}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaNuevoPrenatalBean.irCuestionarioCovidPrenatal}" immediate="true"
                                            rendered="#{menuHistoriaNuevoPrenatalBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaNuevoPrenatalBean.irMotivoPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaNuevoPrenatalBean.irAntecedentesGeneralesPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderAntecedentesGenerales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaNuevoPrenatalBean.irAntecedentesGinecologicosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Antecedentes Obstetricos"
                                           action="#{menuHistoriaNuevoPrenatalBean.irAntecedentesObstetricosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderAntecedentesObstetricos}"/>
                            <h:commandLink value="Antecedentes Familiares"
                                           action="#{menuHistoriaNuevoPrenatalBean.irAntecedentesFamiliaresPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderAntecedentesFamiliares}"/>
                            <h:commandLink value="Gestación"
                                           action="#{menuHistoriaNuevoPrenatalBean.irGestacionPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderGestacionPrenatal}"/>
                            <h:commandLink value="Valoracion Biopsicosocial"
                                           action="#{menuHistoriaNuevoPrenatalBean.irValoracionBiopsicosocialNuevoPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderValoracionBiopsicosocial}"/>
                             <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaNuevoPrenatalBean.irEncuestaViolenciaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderEncuestaViolencia}"/>               
                             <h:commandLink value="Tamizaje Prenatal"
                                           action="#{menuHistoriaNuevoPrenatalBean.irTamizajePrenatal}" immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderTamizajePrenatal}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaNuevoPrenatalBean.irEscalaValoracionCaidasNuevoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderEscalaCaidas}"/> 
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaNuevoPrenatalBean.irExamenFisicoGeneralNuevoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderExamenFisico}"/>               
                            <h:commandLink value="Exámen Fisico Prenatal"
                                           action="#{menuHistoriaNuevoPrenatalBean.irExamenFisicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderExamenFisicoPrenatal}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaNuevoPrenatalBean.irImpDiagnosticaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderImpresionDiagnostica}"/>
                         
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaNuevoPrenatalBean.irServiciosAdmisionPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaNuevoPrenatalBean.irAnatPatologicaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaNuevoPrenatalBean.irControlSinCostoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaNuevoPrenatalBean.irFormulaMedicaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta && !menuHistoriaNuevoPrenatalBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaNuevoPrenatalBean.irVademecumMedicoPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta && menuHistoriaNuevoPrenatalBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaNuevoPrenatalBean.irRemHospitalizacionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaNuevoPrenatalBean.irIncapacidadPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaNuevoPrenatalBean.irInterConsultaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaNuevoPrenatalBean.irOrdenCirugiaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaNuevoPrenatalBean.irRecomedacionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaNuevoPrenatalBean.irReferenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaNuevoPrenatalBean.irReservaSangrePrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaNuevoPrenatalBean.irCertMedicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaNuevoPrenatalBean.irCertAsistenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaNuevoPrenatalBean.irExamElectrofisiologicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaNuevoPrenatalBean.irExamImagenPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaNuevoPrenatalBean.irExamLaboratorioPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuHistoriaNuevoPrenatalBean.irCerrarConsultaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaNuevoPrenatalBean.irResumenHistoriaPrenatal}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaNuevoPrenatalBean.irPausarConsultaPrenatal}"
                                           rendered="#{menuHistoriaNuevoPrenatalBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>