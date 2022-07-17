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
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irDatosAnticoncepcion}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irCuestionarioCovidAnticoncepcion}" immediate="true"
                                            rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irMotivoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAntecedentesGeneralesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderAntecedentesGenerales && menuHistoriaAnticoncepcionEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAntecedentesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderAntecedentesGenerales && !menuHistoriaAnticoncepcionEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Temporales"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAntecedentesTemporalesAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderAntecedentesTemporales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAntecedentesGinecologicosAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irEncuestaViolenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irExamenFisicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irImpDiagnosticaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Métodos Planificación"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irMetodoPlanificacion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderMetodosPlanificacion}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irServiciosAdmisionMetodosPlanificacion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta && !menuHistoriaAnticoncepcionEnfermeriaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irFormulaMedicaAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta && menuHistoriaAnticoncepcionEnfermeriaBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAplicacionRetiro}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                              <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAnatPatologicaControl}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>                                           
                          <h:commandLink value=" > Control"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irControlSinCostoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irRemHospitalizacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irIncapacidadAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irInterConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irOrdenCirugiaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                              <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irRecomedacionAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irReferenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irAutorizacionServicioAnticoncepcion}"
                                           immediate="true" rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>                 
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irReservaSangreAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irCertMedicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irCertAsistenciaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irExamElectrofisiologicoAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irExamImagenAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irExamLaboratorioAnticoncepcion}" immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irCerrarConsultaAnticoncepcion}"
                                           immediate="true"
                                           rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irResumenHistoriaAnticoncepcion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaAnticoncepcionEnfermeriaBean.irPausarConsultaAnticoncepcionEnfermeria}"
                                   rendered="#{menuHistoriaAnticoncepcionEnfermeriaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>