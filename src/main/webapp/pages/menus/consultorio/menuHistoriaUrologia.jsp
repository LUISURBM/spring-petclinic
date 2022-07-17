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
                    <t:panelTab label="Procesos de Urología" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaUrologiaBean.irDatosUrologia}" immediate="true"/>
                                           
                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaUrologiaBean.irCuestionarioCovidUrologia}" immediate="true"
                                            rendered="#{menuHistoriaUrologiaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaUrologiaBean.irMotivoUrologia}" immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderMotivo}"/>
                            <h:commandLink value="Paraclinicos"
                                           action="#{menuHistoriaUrologiaBean.irParaclinicosUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderParaclinicos}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaUrologiaBean.irAntecedentesGeneralesUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderAntecedentesGenerales && menuHistoriaUrologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaUrologiaBean.irAntecedentesUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderAntecedentesGenerales && !menuHistoriaUrologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaUrologiaBean.irAntecedentesGinecologicosUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaUrologiaBean.irEncuestaViolenciaUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaUrologiaBean.irEscalaValoracionCaidasUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaUrologiaBean.irExamenFisicoUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaUrologiaBean.irImpDiagnosticaUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderImpresionDiagnostica}"/>
                            <h:outputText value="Ordenes Médicas (Cirugía/Procedimientos)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaUrologiaBean.renderConducta && menuHistoriaUrologiaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaUrologiaBean.irOrdenLiquidosUrologia}"
                                           rendered="#{menuHistoriaUrologiaBean.renderConducta && menuHistoriaUrologiaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaUrologiaBean.irOrdenMedicamentosUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderConducta && menuHistoriaUrologiaBean.renderOrdenesMedicas}"/>
                        <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaUrologiaBean.irRegistrarOtrasOrdenesUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderConducta && menuHistoriaUrologiaBean.renderOrdenesMedicas}"/>
                                           
                                           
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaUrologiaBean.irServiciosAdmisionUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaUrologiaBean.irAnatPatologicaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Violencia Sivigila"
                                           action="#{menuHistoriaUrologiaBean.irViolenciaSivigilaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaUrologiaBean.irControlSinCostoUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaUrologiaBean.irVademecumMedicoUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderConducta && menuHistoriaUrologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaUrologiaBean.irRemHospitalizacionUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaUrologiaBean.irIncapacidadUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaUrologiaBean.irInterConsultaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaUrologiaBean.irOrdenCirugiaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaUrologiaBean.irRecomedacionUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaUrologiaBean.irReferenciaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaUrologiaBean.irAutorizacionServicioUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaUrologiaBean.irReservaSangreUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaUrologiaBean.irCertMedicoUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaUrologiaBean.irCertAsistenciaUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaUrologiaBean.irExamElectrofisiologicoUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaUrologiaBean.irExamImagenUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaUrologiaBean.irExamLaboratorioUrologia}"
                                           immediate="true" rendered="#{menuHistoriaUrologiaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaUrologiaBean.irCerrarConsultaUrologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaUrologiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaUrologiaBean.irResumenHistoriaUrologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaUrologiaBean.irPausarConsultaUrologia}"
                                   rendered="#{menuHistoriaUrologiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>