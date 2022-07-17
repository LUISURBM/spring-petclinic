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
                    <t:panelTab label="Procesos de Anticoncepción Temporal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irDatosAnticoncepcion}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irCuestionarioCovidAnticoncepcionEnfermeriaInsercion}" immediate="true"
                                            rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderAntecedentesGenerales && menuHistoriaAnticoncepcionEnfermeriaInsercion.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionEnfermeriaInsercion.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderMetodosPlanificacion}"/>
                            <h:commandLink value="Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderAplicacion}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irServiciosAdmisionAnticoncepcionEnfermeriaInsercion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                                						  <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta && menuHistoriaAnticoncepcionEnfermeriaInsercion.renderVademecum}"/>
                          <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                              <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                             <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderConducta && !menuHistoriaAnticoncepcionEnfermeriaInsercion.renderVademecum}"/>
                                           
                          
                                           
                        
                            
                          
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia 2" id="divToolsAccordionResHis" style="color:red">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.irPausarConsultaAnticoncepcionEnfermeriaInsercion}"
                                   rendered="#{menuHistoriaAnticoncepcionEnfermeriaInsercion.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>