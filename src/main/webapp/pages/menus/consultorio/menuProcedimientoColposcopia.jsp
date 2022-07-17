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
                    <t:panelTab label="Procesos de Colposcopia" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuProcedimientoColposcopiaBean.irDatosColposcopia}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuProcedimientoColposcopiaBean.irCuestionarioCovidColposcopia}" immediate="true"
                                            rendered="#{menuProcedimientoColposcopiaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuProcedimientoColposcopiaBean.irMotivoColposcopia}" immediate="true"
                                           rendered="#{menuProcedimientoColposcopiaBean.renderMotivo}"/>
                            
                            <h:commandLink value="Antecedentes Colposcopia"
                                           action="#{menuProcedimientoColposcopiaBean.irAntecedentesColposcopia}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoColposcopiaBean.renderAntecedentesGenerales}"/>
                                           
                                           
                          
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuProcedimientoColposcopiaBean.irEncuestaViolenciaColposcopia}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoColposcopiaBean.renderEncuestaViolencia}"/>
                                           
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuProcedimientoColposcopiaBean.irEscalaValoracionCaidasColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderEscalaCaidas}"/>                
                                           
                             <h:commandLink value="Colposcopia"
                                           action="#{menuProcedimientoColposcopiaBean.irRegistroColposcopia}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoColposcopiaBean.renderRegistroColposcopia}"/>
                             <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuProcedimientoColposcopiaBean.irImpDiagnosticaColposcopia}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoColposcopiaBean.renderImpresionDiagnostica}"/>
                          
            
                           <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                              <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuProcedimientoColposcopiaBean.irAnatPatologicaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                              <h:commandLink value=" > Control"
                                           action="#{menuProcedimientoColposcopiaBean.irControlSinCostoColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoColposcopiaBean.irFormulaMedicaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta && !menuProcedimientoColposcopiaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoColposcopiaBean.irVademecumMedicoColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta && menuProcedimientoColposcopiaBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuProcedimientoColposcopiaBean.irRemHospitalizacionColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuProcedimientoColposcopiaBean.irIncapacidadColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuProcedimientoColposcopiaBean.irInterConsultaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuProcedimientoColposcopiaBean.irOrdenCirugiaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuProcedimientoColposcopiaBean.irRecomedacionColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuProcedimientoColposcopiaBean.irReferenciaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuProcedimientoColposcopiaBean.irReservaSangreColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuProcedimientoColposcopiaBean.irCertMedicoColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuProcedimientoColposcopiaBean.irCertAsistenciaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuProcedimientoColposcopiaBean.irExamElectrofisiologicoColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuProcedimientoColposcopiaBean.irExamImagenColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuProcedimientoColposcopiaBean.irExamLaboratorioColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderConducta}"/>
                              <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuProcedimientoColposcopiaBean.irCerrarConsultaColposcopia}"
                                           immediate="true" rendered="#{menuProcedimientoColposcopiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                                              
                                  <h:commandLink value="Historia Total"
                                           action="#{menuProcedimientoColposcopiaBean.irResumenHistoriaColposcopia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuProcedimientoColposcopiaBean.irPausarConsultaColposcopia}"
                                   rendered="#{menuProcedimientoColposcopiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>