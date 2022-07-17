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
                                           action="#{menuProcedimientoConsultorioBean.irDatosProcedimientoConsultorio}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuProcedimientoConsultorioBean.irCuestionarioCovidProcedimientoConsultorio}"
                                           immediate="true" rendered="#{menuProcedimientoConsultorioBean.renderCovid}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuProcedimientoConsultorioBean.irEscalaValoracionCaidasProcedimientosConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Procedimientos en Consultorio"
                                           action="#{menuProcedimientoConsultorioBean.irProcedimientosConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderProcedimiento}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuProcedimientoConsultorioBean.irServiciosAdmisionProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuProcedimientoConsultorioBean.irAnatPatologicaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuProcedimientoConsultorioBean.irControlSinCostoProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoConsultorioBean.irFormulaMedicaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta && !menuProcedimientoConsultorioBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuProcedimientoConsultorioBean.irVademecumMedicoProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta && menuProcedimientoConsultorioBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuProcedimientoConsultorioBean.irRemHospitalizacionProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuProcedimientoConsultorioBean.irIncapacidadProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuProcedimientoConsultorioBean.irInterConsultaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuProcedimientoConsultorioBean.irOrdenCirugiaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuProcedimientoConsultorioBean.irRecomedacionProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuProcedimientoConsultorioBean.irReferenciaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuProcedimientoConsultorioBean.irReservaSangreProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuProcedimientoConsultorioBean.irCertMedicoProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuProcedimientoConsultorioBean.irCertAsistenciaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuProcedimientoConsultorioBean.irExamElectrofisiologicoProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuProcedimientoConsultorioBean.irExamImagenProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuProcedimientoConsultorioBean.irExamLaboratorioProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuProcedimientoConsultorioBean.irCerrarConsultaProcedimientoConsultorio}"
                                           immediate="true"
                                           rendered="#{menuProcedimientoConsultorioBean.renderCerrarConsulta}"/>
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
                                           action="#{menuProcedimientoConsultorioBean.irPausarConsultaProcedimientosConsultorio}"
                                           rendered="#{menuProcedimientoConsultorioBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>