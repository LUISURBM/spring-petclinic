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
                    <t:panelTab label="Procesos de Preanestesia" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaPreanestesiaBean.irDatosPreanestesia}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaPreanestesiaBean.irCuestionarioCovidPreanestesia}" immediate="true"
                                            rendered="#{menuHistoriaPreanestesiaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaPreanestesiaBean.irMotivoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderMotivo}"/>
                            <h:commandLink value="Valoración Preanestesia"
                                           action="#{menuHistoriaPreanestesiaBean.irValoracionPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderValoracion}"/>
                            <h:commandLink value="Cuestionario Preanestesia"
                                           action="#{menuHistoriaPreanestesiaBean.irCuestionarioPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderCuestionario}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaPreanestesiaBean.irEscalaValoracionCaidasPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderEscalaCaidas}"/>                     
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaPreanestesiaBean.irExamenFisicoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderExamen}"/>
                            <h:commandLink value="Exámen Fisico Preanestesia"
                                           action="#{menuHistoriaPreanestesiaBean.irExamenFisicoGeneralPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderExamenPreanestesia}"/>
                            <h:commandLink value="Resultados Paraclinicos"
                                           action="#{menuHistoriaPreanestesiaBean.irResultadosPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderResultados}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaPreanestesiaBean.irImpDiagnosticaPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderImpresionDiagnostica}"/>
                                           
                            <h:outputText value="Ordenes Médicas" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaPreanestesiaBean.irOrdenLiquidosPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaPreanestesiaBean.irOrdenMedicamentosPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/> 
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuHistoriaPreanestesiaBean.irRegistrarOtrasOrdenesPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaPreanestesiaBean.irServiciosAdmisionPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaPreanestesiaBean.irAnatPatologicaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaPreanestesiaBean.irControlSinCostoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                                <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPreanestesiaBean.irFormulaMedicaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta && !menuHistoriaPreanestesiaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaPreanestesiaBean.irVademecumMedicoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta && menuHistoriaPreanestesiaBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaPreanestesiaBean.irRemHospitalizacionPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaPreanestesiaBean.irIncapacidadPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaPreanestesiaBean.irInterConsultaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaPreanestesiaBean.irOrdenCirugiaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaPreanestesiaBean.irRecomedacionPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaPreanestesiaBean.irReferenciaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaPreanestesiaBean.irAutorizacionServicioPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>                
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaPreanestesiaBean.irReservaSangrePreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaPreanestesiaBean.irCertMedicoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaPreanestesiaBean.irCertAsistenciaPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaPreanestesiaBean.irExamElectrofisiologicoPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaPreanestesiaBean.irExamImagenPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaPreanestesiaBean.irExamLaboratorioPreanestesia}"
                                           immediate="true" rendered="#{menuHistoriaPreanestesiaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaPreanestesiaBean.irCerrarConsultaPreanestesia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPreanestesiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaPreanestesiaBean.irResumenHistoriaPreanestesia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaPreanestesiaBean.irPausarConsultaPreanestesia}"
                                   rendered="#{menuHistoriaPreanestesiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>