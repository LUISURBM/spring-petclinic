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
                    <t:panelTab label="Procesos de Anticoncepción Temporal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irDatosAnticoncepcion}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irCuestionarioCovidAnticoncepcion}" immediate="true"
                                            rendered="#{menuHistoriaControlAnticoncepcionBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderAntecedentesGenerales && menuHistoriaControlAnticoncepcionBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderAntecedentesGenerales && !menuHistoriaControlAnticoncepcionBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                            action="#{menuHistoriaControlAnticoncepcionBean.irEscalaValoracionCaidasControlAnticoncepcionTemporal}"
                                           immediate="true" 
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderEscalaCaidas}"/>      
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderMetodosPlanificacion}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuHistoriaControlAnticoncepcionBean.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta && !menuHistoriaControlAnticoncepcionBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta && menuHistoriaControlAnticoncepcionBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irCerrarConsultaControlAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                         
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionBean.irPausarConsultaControlAnticoncepcionTemporal}"
                                           rendered="#{menuHistoriaControlAnticoncepcionBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>