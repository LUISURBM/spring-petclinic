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
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" style="margin-top:0;"
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
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irDatosAnticoncepcion}"
                                           immediate="true"/>
                             <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irCuestionarioCovidAnticoncepcionEnfermeriaRetiro}" immediate="true"
                                            rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderAntecedentesGenerales && menuHistoriaAnticoncepcionEnfermeriaRetiro.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionEnfermeriaRetiro.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderAplicacion}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irServiciosAdmisionAnticoncepcionEnfermeriaRetiro}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAnatPatologicaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>                   
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta && !menuHistoriaAnticoncepcionEnfermeriaRetiro.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irVademecumMedicoAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta && menuHistoriaAnticoncepcionEnfermeriaRetiro.renderVademecum}"/>
                              <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                               <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                             <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                          
                         
                              <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irExamLaboratorioAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderConducta && !menuHistoriaAnticoncepcionEnfermeriaRetiro.renderVademecum}"/>          
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia 1" id="divToolsAccordionResHis" style="color:red">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.irPausarConsultaAnticoncepcionEnfermeriaRetiro}"
                                   rendered="#{menuHistoriaAnticoncepcionEnfermeriaRetiro.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>