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
                    <t:panelTab label="Procedimiento en Consultorio" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuProcedimientoIveBean.irDatosProcedimientoConsultorio}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuProcedimientoIveBean.irCuestionarioCovidProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderCovid}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuProcedimientoIveBean.irEscalaValoracionCaidasProcedimientosIve}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoIveBean.renderEscalaCaidas}"/>
                            <h:commandLink value="Procedimientos en Consultorio"
                                           action="#{menuProcedimientoIveBean.irProcedimientosConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderProcedimiento}"/>
                            <h:outputText value="Ordenes Médicas (Cirugía)" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoIveBean.renderConducta && menuProcedimientoIveBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuProcedimientoIveBean.irOrdenLiquidosProcedimientoConsultorio}"
                                           rendered="#{menuProcedimientoIveBean.renderConducta && menuProcedimientoIveBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuProcedimientoIveBean.irOrdenMedicamentosProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoIveBean.renderConducta && menuProcedimientoIveBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuProcedimientoIveBean.irAnatPatologicaProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuProcedimientoIveBean.irControlSinCostoProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoIveBean.irFormulaMedicaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoIveBean.renderConducta && !menuProcedimientoIveBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoIveBean.irVademecumMedicoProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoIveBean.renderConducta && menuProcedimientoIveBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuProcedimientoIveBean.irRemHospitalizacionProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuProcedimientoIveBean.irIncapacidadProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuProcedimientoIveBean.irInterConsultaProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuProcedimientoIveBean.irOrdenCirugiaProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuProcedimientoIveBean.irRecomedacionProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuProcedimientoIveBean.irReferenciaProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuProcedimientoIveBean.irReservaSangreProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuProcedimientoIveBean.irCertMedicoProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuProcedimientoIveBean.irCertAsistenciaProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuProcedimientoIveBean.irExamElectrofisiologicoProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuProcedimientoIveBean.irExamImagenProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuProcedimientoIveBean.irExamLaboratorioProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoIveBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuProcedimientoIveBean.irCerrarConsultaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoIveBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="a" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuProcedimientoIveBean.irPausarConsultaProcedimientosIve}"
                                           rendered="#{menuProcedimientoIveBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>