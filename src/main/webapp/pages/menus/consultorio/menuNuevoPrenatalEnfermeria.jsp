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
                    <t:panelTab label="Historia Nuevo Prenatal" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irDatosPrenatal}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irCuestionarioCovidPrenatal}" immediate="true"
                                            rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderCovid}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irMotivoPrenatal}" immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irAntecedentesGeneralesPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderAntecedentesGenerales}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irAntecedentesGinecologicosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Antecedentes Obstetricos"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irAntecedentesObstetricosPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderAntecedentesObstetricos}"/>
                            <h:commandLink value="Antecedentes Familiares"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irAntecedentesFamiliaresPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderAntecedentesFamiliares}"/>
                            <h:commandLink value="Gestación"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irGestacionPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderGestacionPrenatal}"/>
                            <h:commandLink value="Valoracion Biopsicosocial"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irValoracionBiopsicosocialNuevoPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderValoracionBiopsicosocial}"/>
                             <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irEncuestaViolenciaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderEncuestaViolencia}"/>
                             <h:commandLink value="Tamizaje Prenatal"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irTamizajePrenatal}" immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderTamizajePrenatal}"/>             
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irExamenFisicoGeneralNuevoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderExamenFisico}"/>               
                            <h:commandLink value="Exámen Fisico Prenatal"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irExamenFisicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderExamenFisicoPrenatal}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irImpDiagnosticaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderImpresionDiagnostica}"/>
                         
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irServiciosAdmisionPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderServiciosAdmision}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irAnatPatologicaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irControlSinCostoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irFormulaMedicaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta && !menuHistoriaNuevoPrenatalEnfermeriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irVademecumMedicoPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta && menuHistoriaNuevoPrenatalEnfermeriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irRemHospitalizacionPrenatal}"
                                           immediate="true" 
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irIncapacidadPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irInterConsultaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irOrdenCirugiaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irRecomedacionPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irReferenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irReservaSangrePrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irCertMedicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irCertAsistenciaPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irExamElectrofisiologicoPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irExamImagenPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irExamLaboratorioPrenatal}"
                                           immediate="true" rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar consulta"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irCerrarConsultaPrenatal}"
                                           immediate="true"
                                           rendered="#{menuHistoriaNuevoPrenatalEnfermeriaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaNuevoPrenatalEnfermeriaBean.irResumenHistoriaEspecificaPrenatal}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>