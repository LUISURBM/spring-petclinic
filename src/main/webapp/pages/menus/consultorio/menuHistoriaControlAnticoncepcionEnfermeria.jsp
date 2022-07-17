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
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irDatosAnticoncepcion}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irCuestionarioCovidAnticoncepcion}" immediate="true"
                                            rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderAntecedentesGenerales && menuHistoriaControlAnticoncepcionEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderAntecedentesGenerales && !menuHistoriaControlAnticoncepcionEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderMetodosPlanificacion}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irServiciosAdmisionControlAnticoncepcionEnfermeria}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta && !menuHistoriaControlAnticoncepcionEnfermeriaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta && menuHistoriaControlAnticoncepcionEnfermeriaBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                             <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAnatPatologicaControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
    
                            <h:commandLink value=" > Control" action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irControlSinCostoControl}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irRemHospitalizacionControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irIncapacidadControl}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irInterConsultaControl}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irOrdenCirugiaControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                              
                            <h:commandLink value=" > Referencia" action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irReferenciaControl}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irAutorizacionServicioControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irReservaSangreControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irCertMedicoControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irCertAsistenciaControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irExamElectrofisiologicoControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irExamImagenControl}"
                                           immediate="true" rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irExamLaboratorioControl}" immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irCerrarConsultaControlAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.irPausarConsultaControlAnticoncepcionEnfermeria}"
                                   rendered="#{menuHistoriaControlAnticoncepcionEnfermeriaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>