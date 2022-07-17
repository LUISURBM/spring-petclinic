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
                    <t:panelTab label="Procesos de IVE" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaInterrupcionBean.irDatosInterrupcion}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaInterrupcionBean.irCuestionarioCovidInterrupcion}" immediate="true"
                                            rendered="#{menuHistoriaInterrupcionBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaInterrupcionBean.irMotivoInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaInterrupcionBean.irAntecedentesGeneralesInterrupcion}"
                                           immediate="true"
                                           rendered="false"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaInterrupcionBean.irAntecedentesInterrupcion}"
                                           immediate="true"
                                           rendered="false"/>
                            <h:commandLink value="Antecedentes Detallados"
                                           action="#{menuHistoriaInterrupcionBean.irAntecedentesDetalladoInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderAntecedentesInterrupcion}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaInterrupcionBean.irAntecedentesGinecologicosInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaInterrupcionBean.irEncuestaViolenciaInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Estado Psicoemocional"
                                           action="#{menuHistoriaInterrupcionBean.irEstadoPsicoemocionalInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderEstadoPsico}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaInterrupcionBean.irEscalaValoracionCaidasInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaInterrupcionBean.irExamenFisicoInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderExamen}"/>
                            <h:commandLink value="Identificación del Riesgo"
                                           action="#{menuHistoriaInterrupcionBean.irIdentificacionRiesgoInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderIdentificacionRiegos}"/>
                            <h:commandLink value="Asesoria"
                                           action="#{menuHistoriaInterrupcionBean.irAsesoriaInterrupcion}"
                                           immediate="true"
                                           rendered="false"/>
                            <h:commandLink value="Certificación Ive"
                                           action="#{menuHistoriaInterrupcionBean.irRemisionIlveInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderRemision}"/>
                             <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaInterrupcionBean.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderMetodos}"/>                  
                              <h:commandLink value="  Aplicacion Retiro P.F."
                                           action="#{menuHistoriaInterrupcionBean.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderDispositivos}"/>               
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaInterrupcionBean.irImpDiagnosticaInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaInterrupcionBean.irImpDiagnosticaInterrupcionIve}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderImpresionDiagnosticaIVE}"/>                                   
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaInterrupcionBean.irServiciosAdmisionInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderServiciosAdmision}"/>
                            <h:outputText value="Ordenes Médicas (Cirugía)" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaInterrupcionBean.renderConducta && menuHistoriaInterrupcionBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaInterrupcionBean.irOrdenLiquidosInterrupcion}"
                                           rendered="#{menuHistoriaInterrupcionBean.renderConducta && menuHistoriaInterrupcionBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaInterrupcionBean.irOrdenMedicamentosInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderConducta && menuHistoriaInterrupcionBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaInterrupcionBean.irAnatPatologicaInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaInterrupcionBean.irControlSinCostoInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaInterrupcionBean.irFormulaMedicaInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderConducta && !menuHistoriaInterrupcionBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaInterrupcionBean.irVademecumMedicoInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderConducta && menuHistoriaInterrupcionBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaInterrupcionBean.irRemHospitalizacionInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaInterrupcionBean.irIncapacidadInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaInterrupcionBean.irInterConsultaInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaInterrupcionBean.irOrdenCirugiaInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaInterrupcionBean.irRegistrarOtrasOrdenesInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderConducta && menuHistoriaInterrupcionBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaInterrupcionBean.irRecomedacionInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaInterrupcionBean.irReferenciaInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaInterrupcionBean.irAutorizacionServicioInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaInterrupcionBean.irReservaSangreInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaInterrupcionBean.irCertMedicoInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaInterrupcionBean.irCertAsistenciaInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaInterrupcionBean.irExamElectrofisiologicoInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaInterrupcionBean.irExamImagenInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaInterrupcionBean.irExamLaboratorioInterrupcion}"
                                           immediate="true" rendered="#{menuHistoriaInterrupcionBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaInterrupcionBean.irCerrarConsultaInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaInterrupcionBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaInterrupcionBean.irResumenHistoriaInterrupcion}"
                                           immediate="true"/>
                            <h:commandLink value="Asesorias IVE"
                                           action="#{menuHistoriaInterrupcionBean.irCertificadosIlve}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaInterrupcionBean.irPausarConsultaInterrupcion}"
                                           rendered="#{menuHistoriaInterrupcionBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>