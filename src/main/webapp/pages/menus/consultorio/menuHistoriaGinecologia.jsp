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
                    <t:panelTab label="Procesos de Ginecología" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaGinecologiaBean.irDatosGinecologia}" immediate="true"/>
                                           
                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaGinecologiaBean.irCuestionarioCovidGinecologia}" immediate="true"
                                            rendered="#{menuHistoriaGinecologiaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaGinecologiaBean.irMotivoGinecologia}" immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderMotivo}"/>
                            <h:commandLink value="Paraclinicos"
                                           action="#{menuHistoriaGinecologiaBean.irParaclinicosGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderParaclinicos}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaGinecologiaBean.irAntecedentesGeneralesGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderAntecedentesGenerales && menuHistoriaGinecologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaGinecologiaBean.irAntecedentesGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderAntecedentesGenerales && !menuHistoriaGinecologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaGinecologiaBean.irAntecedentesGinecologicosGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaGinecologiaBean.irEncuestaViolenciaGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaGinecologiaBean.irEscalaValoracionCaidasGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaGinecologiaBean.irExamenFisicoGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaGinecologiaBean.irImpDiagnosticaGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderImpresionDiagnostica}"/>
                            <h:outputText value="Ordenes Médicas (Cirugía/Procedimientos)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaGinecologiaBean.renderConducta && menuHistoriaGinecologiaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaGinecologiaBean.irOrdenLiquidosGinecologia}"
                                           rendered="#{menuHistoriaGinecologiaBean.renderConducta && menuHistoriaGinecologiaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaGinecologiaBean.irOrdenMedicamentosGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderConducta && menuHistoriaGinecologiaBean.renderOrdenesMedicas}"/>
                        <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaGinecologiaBean.irRegistrarOtrasOrdenesGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderConducta && menuHistoriaGinecologiaBean.renderOrdenesMedicas}"/>
                                           
                                           
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaGinecologiaBean.irServiciosAdmisionGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaGinecologiaBean.irAnatPatologicaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Violencia Sivigila"
                                           action="#{menuHistoriaGinecologiaBean.irViolenciaSivigilaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaGinecologiaBean.irControlSinCostoGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaGinecologiaBean.irVademecumMedicoGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderConducta && menuHistoriaGinecologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaGinecologiaBean.irRemHospitalizacionGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaGinecologiaBean.irIncapacidadGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaGinecologiaBean.irInterConsultaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >Interconsulta, apoyo diagnóstico o terapéutico"
                                           action="#{menuHistoriaGinecologiaBean.irInterConsultaApoyoDiag}"
                                           immediate="true" rendered="false" />
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaGinecologiaBean.irOrdenCirugiaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaGinecologiaBean.irRecomedacionGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaGinecologiaBean.irReferenciaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaGinecologiaBean.irAutorizacionServicioGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaGinecologiaBean.irReservaSangreGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaGinecologiaBean.irCertMedicoGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaGinecologiaBean.irCertAsistenciaGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaGinecologiaBean.irExamElectrofisiologicoGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaGinecologiaBean.irExamImagenGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaGinecologiaBean.irExamLaboratorioGinecologia}"
                                           immediate="true" rendered="#{menuHistoriaGinecologiaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaGinecologiaBean.irCerrarConsultaGinecologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaGinecologiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaGinecologiaBean.irResumenHistoriaGinecologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaGinecologiaBean.irPausarConsultaGinecologia}"
                                   rendered="#{menuHistoriaGinecologiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>