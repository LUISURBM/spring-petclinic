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
                    <t:panelTab label="Procesos de Control Preanestesia" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaControlPreanestesiaBean.irDatosControlPreanestesia}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaControlPreanestesiaBean.irCuestionarioCovidPreanestesia}" immediate="true"
                                            rendered="#{menuHistoriaControlPreanestesiaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaControlPreanestesiaBean.irMotivoControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderMotivo}"/>
                            <h:commandLink value="Valoración Preanestesia"
                                           action="#{menuHistoriaControlPreanestesiaBean.irValoracionControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderValoracion}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaControlPreanestesiaBean.irEscalaValoracionCaidasControlPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaControlPreanestesiaBean.renderEscalaCaidas}"/>      
                            <h:commandLink value="Control"
                                           action="#{menuHistoriaControlPreanestesiaBean.irControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderControl}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaControlPreanestesiaBean.irServiciosAdmisionControlPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaControlPreanestesiaBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaControlPreanestesiaBean.irAnatPatologicaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaControlPreanestesiaBean.irControlSinCostoControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlPreanestesiaBean.irFormulaMedicaControlPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta && !menuHistoriaControlPreanestesiaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaControlPreanestesiaBean.irVademecumMedicoControlPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta && menuHistoriaControlPreanestesiaBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaControlPreanestesiaBean.irRemHospitalizacionControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaControlPreanestesiaBean.irIncapacidadControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaControlPreanestesiaBean.irInterConsultaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaControlPreanestesiaBean.irOrdenCirugiaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaControlPreanestesiaBean.irRecomedacionControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaControlPreanestesiaBean.irReferenciaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaControlPreanestesiaBean.irReservaSangreControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaControlPreanestesiaBean.irCertMedicoControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaControlPreanestesiaBean.irCertAsistenciaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaControlPreanestesiaBean.irExamElectrofisiologicoControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaControlPreanestesiaBean.irExamImagenControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaControlPreanestesiaBean.irExamLaboratorioControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaControlPreanestesiaBean.irCerrarConsultaControlPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaControlPreanestesiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaControlPreanestesiaBean.irResumenHistoriaPreanestesia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaControlPreanestesiaBean.irPausarConsultaControlPreanestesia}"
                                   rendered="#{menuHistoriaControlPreanestesiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>